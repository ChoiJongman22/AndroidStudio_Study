package com.jongman22.room_viewmodel

import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jongman22.room_viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var adapter: RecyclerAdapter? = null
    private val p: Paint = Paint()
    private lateinit var binding:ActivityMainBinding
    private var db: MemoDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSwipe()
        binding.btnPlus.setOnClickListener{
            val edittext = EditText(this)
            val builder:AlertDialog.Builder=AlertDialog.Builder(this)
            builder.setTitle("Item 추가")
            builder.setMessage("제목을 입력해 주세요.")
            builder.setView(edittext)
            builder.setPositiveButton("입력"
            ) { dialog, which ->
                //제목 입력, DB추가
                if (!edittext.text.toString().isEmpty()) {
                    Thread(Runnable {
                        db!!.memoDao().insert( Memo(null,edittext.text.toString(), null))
                    }).start()
                }
            }
            builder.setNegativeButton("취소"
            ) { dialog, which ->
                //취소
            }
            builder.show()
        }
        db = MemoDatabase.getInstance(this)
        binding.rvView.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.rvView.layoutManager = layoutManager

        //UI 갱신 (라이브데이터 Observer 이용, 해당 디비값이 변화가생기면 실행됨)
        db!!.memoDao().getAll().observe(this, androidx.lifecycle.Observer{
            // update UI
            adapter = RecyclerAdapter(db!!,it)
            binding.rvView.adapter = adapter
        })


    }

    private fun initSwipe() {
        val simpleItemTouchCallback: ItemTouchHelper.SimpleCallback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT /* | ItemTouchHelper.RIGHT */) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                if (direction == ItemTouchHelper.LEFT) {
                    Thread{
                        adapter?.getItem()?.get(position)?.let { db!!.memoDao().delete(it) }
                    }.start()
                } else {
                    //오른쪽으로 밀었을때.
                }
            }

            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {
                super.onChildDraw(
                    c,
                    recyclerView,
                    viewHolder,
                    dX,
                    dY,
                    actionState,
                    isCurrentlyActive
                )
                var icon: Bitmap
                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                    val itemView: View = viewHolder.itemView
                    val height =
                        itemView.getBottom().toFloat() - itemView.getTop().toFloat()
                    val width = height / 3
                    if (dX > 0) {
                        //오른쪽으로 밀었을 때
                    } else {
                        p.setColor(Color.parseColor("#D32F2F"))
                        val background = RectF(
                            itemView.getRight().toFloat() + dX,
                            itemView.getTop().toFloat(),
                            itemView.getRight().toFloat(),
                            itemView.getBottom().toFloat()
                        )
                        c.drawRect(background, p)
                        /*
                         * icon 추가할 수 있음.
                         */
                        //icon = BitmapFactory.decodeResource(getResources(), R.drawable.icon_png); //vector 불가!
                        // RectF icon_dest = new RectF((float) itemView.getRight() - 2 * width, (float) itemView.getTop() + width, (float) itemView.getRight() - width, (float) itemView.getBottom() - width);
                        //c.drawBitmap(icon, null, icon_dest, p);
                    }
                }

            }

        }
        val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)
        itemTouchHelper.attachToRecyclerView(binding.rvView)
    }
}