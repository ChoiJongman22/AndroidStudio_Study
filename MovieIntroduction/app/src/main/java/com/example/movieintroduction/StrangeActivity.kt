package com.example.movieintroduction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.movieintroduction.databinding.ActivityIronmanBinding
import com.example.movieintroduction.databinding.ActivityStrangeBinding

class StrangeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityStrangeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this@StrangeActivity)
            .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRsr5ZTF3xd6cKwu0OqBCm4_iyH_oxpxoSMKQ&usqp=CAU")
            .into(binding.doctor)
        Glide.with(this@StrangeActivity)
            .load("data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxMTEhUTEhIWFhUXGBgWGBYVFRUVFRUVFhcXFhcVFRUYHSggGBolGxUVITEhJSkrLi4uFx8zODMtNygtLisBCgoKDg0OGhAQGi0lICUtLS0tLS0tLS0tLS8tLS0tLS0tLTUtLS0tLSstLS0tLS0tKy0tLS0tLS0tLS0tLS0tLf/AABEIAJkBSQMBIgACEQEDEQH/xAAcAAACAwEBAQEAAAAAAAAAAAAEBQIDBgEABwj/xABCEAABAwIEBAMFBQYFAgcAAAABAAIRAyEEEjFBBVFhcSKBoQYTMpGxQlLB0fAHFCMzguEVYnKSoiTxFjRDU2Nzsv/EABoBAAIDAQEAAAAAAAAAAAAAAAECAAMEBQb/xAAnEQACAgICAQQBBQEAAAAAAAAAAQIRAyESMQQTIkFRFBUzYXGBMv/aAAwDAQACEQMRAD8AwzqaJ4dX93Ua7kqXlRaUF2PLo0XBMYamPZUdzPlZPP2g48VKYa3ZY7hJ/iiDzRnF3nI6TN1by0U8fcOfYY5WT3Sj2kfmxD+6Y+yZin80l4s6a7+6T4LAJyi4K0iVUQgE8G8jdNOF48t8L9OaCohHCiC09lCMPxWFzeNhWdfN0bg8a6kYddqsx1NjnDIfi1UZEIgTCucfAiuJ8MdS6g7oOp8KgTjzYLrnkFcOgUqjbqEoKqYwlgaUdQrllO26UOGiaP8A5LU8RJHGYp0yStHwbipaDuCsmDdFs47SoNNsztmjTuT+SLutAo0XEcaDBAhb79m9dzqLp0DiB8gfxXw3E+1bnmfdtHz/ADW5/Z1+0OlRd7nEMyNebVQZa0n77TcDqCeyRR0Rn2teXAV5QFkl1QXlCWTXFxeQDZJcXF5QFnV5C8QrFrCRqo8LrF1NpdruiSwtcIXpXpUIcAXoUpUSVCHFwrsrhcFCHHJNXfDvNOS8c1nsX/NSyGiEg+PyVcqL6kO8kF++t5hSg2fCaii1kqVQKdEJ0rA2W4Rpa6URjqmZsDVDSvFyfihLHvAMWymwBxgpTjTNRzhuSVQCuEqcUG2WEqprCpBdBR4RJyZawwiaOKEEFBPfZRplK4INsKrgGUNTFlPdeAVclRbDYfhceHQyrcbEpfxTDgOIZcaqNQIrAYkMdLhIKCdkca6FbhcLtY3TOvgveOL6Y8IOiWVdSiAkdkbiKvgaEFuFPi5LaWYbD5SQPxTRFkhbiOIyYbpzSpznPda6vZQcZI2BPlC+icEwFJlJmRolzQ4ne4nXzSOdFkcdnzynhnRMKfuzyK+pVGU92N+QXqTmCxaI7CFOYfSBfZj9qVegGMr/AMVlgSYD2gAAZdoEaddV9q4VxGniKTatJwcxwkEGR/bsYI3ANl+c/argjKZFWjZjtWgTlOthyN+y+ofsPe/90qAghhrOLAdobTzx0Jd8weaa01ZTKNOj6OvLy8oKdXlxelQh1eXF6VCAnEawa26q4TiWvbZD8cdmaQDsh/ZhmVpB5oJ7C18j5eXl5EB5eK8VEqEIVqkBBYl3VRfVzVI2b9ULiXSSZTpCSZXUrkboTE4gBwUMWTzSDiGLc6q0N0GpQmhsbHNTHZnkcglnvWoTF48CYSj/ABIpaGMQ90rgUnheKJCBceajJ5rhK9CFsiPB55rpcVAqaFjUc947mve8dzXg1TaxDkx+IQynYGV2kwyq20iYTbD0Z2SvNxLYYLBW0irTh04wfDi4wASeglNv/DlTcBvcj6BZ5eTH7NK8ekY19JVPpran2XcdHsJG0kedwlWP4HUpiXMMc9R80sPJi/kEsDEmHruYDl0iT2kD6kKZwDXszN+Ldcr0FGgS02WqM7M08YGWQ6EVxEAUy06OaBI5yCPoovu6UVjqYezJfMS0CI1JAEztdPdJlXFuSRDgOBZDgHT4Zc4XIHc9kwo8Yo0QKYp1IaAATBkfir/ZbBRTdNi8xzsB/cobjHs8wXmXTOYnToFm5XI28KiEji9N9xPaIPyVdbjVJmpPkCT6KXBeEkDxmZFkhx3Cz7x4LrSYhMmLJBfFOLMq0z7sm0GHCLSBbXnzX1D9jIP7k52WAaroJ3gNBgbDS+9+S+SUeEODH3kFjh1Bi3qvuP7N8L7vhuHBBBc01DP/AMhLgR0ghWQZnypmnzL2ZQJXi5OZycrkqIK8SoQlKpxb4aVYCqMcfCoRGUxuJdJuUOzGP5xorccfEbINtPM4HqPqinoZrZ9Awx8I7KxU4d/hHZUY/FZBmBUFC3OQ+KxIa0lRr1CacjWEopudUaMx79VOg1YBh8Y4FxIguM+W3ohm8YGZwOyF4zxRrapE6D5LKv8AaCmC+9ynu42hFFKWzT4nj1IjVAjiLBJOhWTZjmQ6TqFXUxcNbGpSy3SZZBVdDDiGLl0NQXvhzQwqElxKHvyTJAbAnKHvFc8IJ4SgOvqLoqBUkLoClBTLcwUgVWwK5jUrLInWlE4enOiGa26YYEGVVJ0XxjYVQwl1quAcDzkOdZnPn0CG9n+GmtUA21J5ALaV8sNYwx9GtEhczyMrbpG2HtR4PpMGVoDQNm/EfMIXE4th/wDTnnqT/wAVTXAMNbzjczGskaeqprUL3kwLBp8IHM6fVYt2XxiibMcwGHt8PWR9ewXsaA/xUnxzZue439fJCPpObc7/AHrNI5iLTdCVmOBgCDrANiNiN2lWxiguG7QHj8G2odMrr3GhPNIn4UhxBFwtYCKjZP8AVO40zd515zOxmvE4QFpj4m23uABb1C2YMtOmJmxKUbXZi6jbq6k6KjRMSCM33SQQD5GFOsy6X8RrAPgjbWV0bTic2MJeouPZq8IcgDW6NaBMRNonzhexGIESUk9n64LnCb5eukifwTLi+IbTYLSToOyxS9sqOi462cdxssEBjpgnNAytE2Hc6+aVM4kKri4iCdbWkbjyS+tj5EOc4E7ZXARyVGDqGfCDG9irOVIq42+h5Sxd8u3ovsnstxSn+70KfvKeZtNjSA9sgtaAQQDYiIhfHf3U5S5utvU/3T3hXs0PjxMMAI8OrjJtPK59VX+VHH2SfjKa7o+yhwOl+yiNV8xbiW0KkUaLA3exzEaTPfyRuF4piYzZ3C5gNnLGwINj3lL+oxXaoT9NlVpn0NdWf9m+IYmsT7xrfdi2eILncmwYPVaCFsxZVkjyXRiy4XjlxfZ0JRxt5kAeaaPMBJsXUBmTBTTnSBDHbM9XqkE2QrnnUEoivSfDpiyUGs4IxdoLhsNxXtJXow0+IEW6ICv7R1qxDGtJ6DVDY1xqEF2yK9ng1lQ1HaAfVXJqipwNfwniT6jMrxBAuFnne0FSmHNgQ1zhPSSmfCuItc97tAdFl8aWuc+4u531QSTF2jJcc4q59R7gdUupYd7ml4BgalaLgXB6T8UGVz/DMnWJOwJ2Ca8RwjGmo2lam0xHRCUq0h4wvsx9FhOytDDPZH1QG2CEe6EU7A40G0mNAJO6pkIRpJVt0QALghqrUaoOaohQD3avwdIF11N9NTwNnXRIMDgmBpMIB7RNkzq1BkN0rebpJDxZZTpAprgMMluH1TzhoWbNpG3C7Zs+B0hToh0eJ5jbQWHrKJoNkkgG5BMCTG1vIlH8JptFKkdfCSOUkn1sltap4XRvlBjWDIn5gLkSVtmtb0QbhvFl0AMHedxJ3/umuGwIy+IST96Hadx3SbD4gU8xdMCCYvyE9vzTyjiGvaPFEi3LdI2olk7oqxeG2iW6kHlaI+SQ8QwwMho+HKQL/CTeDPa3TunmMrENLW+Ixa+vz7JJjcScxH2m0rdDJGo1nQADZCOWNjRUqA+HxnO4c0vi2okOHncdiVSAWPLNTmlx3MS3U8wJ81x2JDXtItDMxsRqTNjtN+zgpVKoLnEi4qG/+xpj1V6e9FjTsQ4/D5ahHX0Wf9o2eHMNWx8jb6wtHxrFt95LiJAE9xrMLOY3HNqBwAsZaCbA9fVdXFfDZzZxfq+0D9mcR/1DB94Ob/xJ+oC1GIqk1mNcIEQCTrO/zWE4TXyV6Z+69pPYOE+kr6Ni6LXsIcNCYI+IHoVTljuy+OS9fQu4yyqCA0tjl4SVZgsI6AXEH5fgk73EPy5p+vmt17HYEQa9TRug5kXJ/XNYvJzcFRoxx1yYdwfAig0Z/wCYRLQdu3UKrHMFQuNR+u06Bt8oHLed4m27LG4oZfGA4mzW+dvNLatPKTlgv+27anuGt5uAE301OluV69svjFLbB69dlNoAOXkAM1Q9QNvTuh8FQrYio0Mb4TEuqODoBMTludjvsh6Ye/N7tktmJILn1HdXO0G55d1qfZDDvaCarmF2f7JBIECGnLa0ntK0YIrLkUZDZsnp4212bThmEZQpNpMFmjXmTck9yjmqFMiFY90BejiklSPNybbtguNqQIWZ4hqd/wBbJ5iqkpJiXeI9p/XVVz7L8ZPDCaTs29u1lncZQy2+RWkwplhHX5oXGUwTEdVE6Gau0ZbFUyBoruHYXPTOsk7ck8xmR9KYui8Ph2MaI1haLMsjE8eZVpx7vMBpZZ9znDcyvoGPrN924ujUrC4x4knqipbI4aCuEu8YM3RGPr5Sb/ElWAJDgdkx4lSztzckH2GK0Vs4c40zV1CSuErR4biBbRLOiRll0yRW2RpbqeVegKeYJqFsXqTQqS9dDkEBljmqoMVwuuQoAg8WVUK+VU4JWOguha6b4KteTqTJSOnURmHrQVRlVo1YnxZ9M4bXzYdt4LSR5G/5oavVAOsQd+R/I+hSn2fx4ByOPhfAJ5HYo7iOGghpmdZFwZ0I/LquXKHFtM6MGmXjQBoGYNFtnt3EdPoOipq1xTIy1DSAAJYWy0jW0d1QakRAuLgTcdWH7Q6KX7/sXQPukGyqyYeSLbLqeMFZ7jSzkgWcR4WxAG/n+CXYqoGzBJggPqPEABtyGNNyQTbqdERUxBglhzOAMMa3KwSIk2Em5/NIMQXPgVLBgAySYaJsajibC/PpZYniknsuxbI0q0l9Qg3BMf5QZM85MD+pGVDlptYfii8EWdUuTG0Az5LwDWtbLokgtbHjqG+V+XUNF8rd7lLeLY8im52cGSQ085kGI6Fwkay7YhXYpNySRfacbM7xjGZqjyNza+w68kNWp3a0XJtA1k2j5ruGGZ7mffYR/t/ieppx5ojCgOrAu+FgLidNATqNOQPMhdtSqNHOgk3KRnKoh7u0/Mtj0KfN4xU91kJJIETrbaTuYSzFmXAuF3kvI0AbctEAWGiKweGL3hrRcn9eX5K1q1sxW+boccEwxcRzK+vYDBNa1tK0MgEf5tST5wfNY72T4S0VmSSYkwY+yJvyWuGKDW1CXTE6XvJHovP+V+5s6d3FRiKeJuz1jkAsQxnV27j6/JQp0x7xtNr6cREODi4hwkuuC2Tr5AIWhichLnatY4i/2neH8XFH+zzWCHm9RzeWgl1/OPRZMcOUlfyaZxcY/wBEKfB6jxldIZoXu1IB+yNgdfkNkdhuHPpD/pyG3nxAEO6z/ZNqrCS0TZEODcukDTzXRxwWJ6Mk80mqYPhuO1qbR7+kXiYL6Vzfcst6Jyca19MOYZHmO8g3B6JW3SGmLG2xOv5pV7wsJLXQSd9JG0HutuPyviRjngUtxVDvH1Rlsb/rdKK7j8W4sf15rtPHZj/FADXQGkTqdQYsBMiV11MiWm4uJ9PrCt9RS2gLHXZyk45SWm48UfUKqu8m43sh8BXgt6ug9jY/X0Um1hlvqHFo0nuhKTLYRQJj6rmkREG/nuu8WruyNLTB37KvH1ZHYn1QeIxstjktOJtxMmeKUhZWqPIvolOLoXTSpXlsIGtUVyKAehTOicYZ/wDCI3QGHMnuu1HZHRKVq2G6VnMSEK9yLquzBLqhVkSiR1zpXcqpa5W5kdgVC+qF5jlZiQh2lBEDKZXXuQ7XrrnIgLAoVF1VkylY6J0yrqTrqqkQrA1JRYpDbCYmIWno8VFRoY90EaOOkHUE9refzw1NxRdLELPlw8kasObj2a5jXAkOENJ3ALZ2/wC+qsNQtHxAdnOHpB+qRYXi7wImRyN47Ik8QECWQDJEHW5BIkHcFZXhmjbHPBhwruOpBHUuPoAJUMSGujwh8aEgQCfutuJ7yhm8Rpg/AT3I/ABdfxYn4AG7TqY5SU0MEn2hZ54L5AMdw403OqF0m5ykgvdI0DvMg6a7b47ihxDzmdScALAAEgDpC11apJuhK9Sy1Y/DjF2ZsnnSa4rozPAp96HkfBsefI+QKNxNGCaTT8biwOFyaY8ZJGnw5fRSGIl3ovcOqhznGPvGf9Wn/ANRnFWkWYpPi39izFNJrOOwaB8/0U84FhIa6q4eANfJtMAXIkiCecHRwS1tKXuJ+0Y8hb6yoYwl5aGuIDRME+ENbPi5DUot+0RR92zfexGI/iy5zbUidwbsBIc3aDImLwEfxHEtDXGRLxmyjMBcvvfpCyXsM8MrtJPheHNBP2pGsbAm3mn3E3FzibZAcpyzabnN1ytN/wDKuB5cG5nWwJWihz8zyHQGhskgAHISQTIuUXwXGubUznxNc4tGQExYZW5dQAAR5pZQrGWyBeWEEWv8IPTM31Wg4K9oq1Aw3ywGGJaJnwcwQQefOdVnSpmnL0O6WIqurfD4L30sRb8EW/GB8NGgPnudOsFJP8RfDmyQ/wCyI9O6jgsW59n/ABAa6E5Tmhw7AhSeZrV2ZHhvZoqVAgzMg28p6pBxsiQCSNTzIOl+lkRQ4gxtxnJ6wB8hql/tHi2Nqvc82nQanfL0Rc+Sv+QY4NS2KsNjH/v1NkmCGsInnP5haqrWvlmSQCe4Gb8Cstwhrfe1MQczst9AB4h4Q2DJJFugndFcKxTiHOqTnLZg2Ilzx+uy2+Nk9yiV5oO3L6GGDbJnkWn/AJNH4rlbV23iP1RuBpBrWuduc39LL/XL8ksxrudyb/7pd+IXRVORkT0VYx3hPl9B+aT13ptxmG02xqRf5kD0aEgfUWnBtGXyXtEKrkO66seZVIBV9GWyTXQqK7rqyFTXUA2RFdSLpCHDVfQyjUp0hHIpeFzOPvBLOJcSBJDPh57lDyeTvkmURbG+IKre0RZWYwwFSwSqUWMsw1GQrzhLTK5g7mAr31RlIJuoyIBe6Fxo3UKjDqp0gZjmlsajtXwlcdVXK4sOYsVVTfzRWyVQVSJCtY4odtcK1mICLiSw2m5FV8RmdIsLBo1hosBO567kkpc3EBWtrhLwGU2E+8XC87KoVBzVrajeaPAPMpfWO6pr1vCexKMLWn7QQXEgBTcRyP5JkmhW0xbg37nbM75Au/BWcHblaQdYS6lWsf8AS71aW/ipcPxEl/yHzj6Ss7XuOhGa4pDF9QAOd8koDySRtq89BfL2A16ojiOLDQG6uOnSfteX4IJhgBv3rnsP7wPJSictj/hmKzOD4gCMo5Nbp5kif6VtcTiGvaKhgB7A031c0jbtF9fEbL5q3FESG7QPMrXey2IY4tpPAJmWkm2b9fVczzoOuSOj40k9BOPoFvODa4MzsT3geYIVlLEh7mPa7LWbY3gPDYIdOxi3K2yaPoGoQ1zfF8OWdWiYnkRz89ylGOwBpuBBIcDZ3PaHcncx/wBly4yT7NrfLRpKGPa8EV3U2VWj4xeLgDOBYG4/JQ4hXq0zmDc7SZa9niHQSNbLMfvFO4qNyONiROUx02NuvYKzB169MltF7HsNyMzIPdpMg9kHBXZWsbXTHNLE1qnwUspNg4NJI68gBzjdA1+DvJmtWZM6GoC4ncQFdh6j4dlqEPdENOcsABkjMRAmAPndB4ptCmDmLsxiWte05Z1YCAfnblzSxaXRODsMwYYWVPETTa05gBlaXm7YJvmloi1g1S4BQcfERDYhov4hMlxn06BL8C1z6raYp5abHHM2ZvoXOJ1IMdLLZ06LWCXA/wCUDV56bwt3ixUW5N7+jP5EnXH7CMXGUNB+IfKm25MdSkr6b3VGiIJMjcAdfkj8JWzVTnInVx+jR0H1UeLwyXtN3DKOg3I9R5la1kalxMix6M9x2pL8o0FvIQB6AJRXY4QTvoo42uQ8yZUn4ttVrWAGRZdXFFpJI5+eUW3f+FNGrYqArpkeFBonN5Ic4Nu60cGY+SKmHNMbILEG6cYfCBsxuq63D2nU3Q9OQXOIpa6Et4tioblGp+icYzA5RIdKy7nMqEl1QB32QNIHeD8kaoTsjhAA4OIkD1O3lumv+L1P/cPyb+SQ4yrDQyb7lU+/UsNGsrgOK41qmx4DiFcard1SWFVFt5GyNxVEECoPPug3YoIrheMBcWO+F31RsFA8yp02DZW1cIZc2bi46pQ975jSNVVLb0XR9q2H4qkLGZmxRXDODNqvaC7K126q4OxpnMZXuJYN7BnDzE26KNSa0wxcVdoL9rODUsM9opPzSLyQYKzhqqVZ73akmFSWO5JoppU2LJpvSLmVFcKqFDTyKmJTCBBrK3BD3jw0WkxPJAE9FynXcx0tsQo7+CKjf8U9g6lKl70VQdPDEa9VmOP4V1Km5rtYVlX21xb2NpucCARFr26ygONcTfXDi7WD8gFRD1lNcn7TRJ4vTdf9XoU8Pe0HNU+C7T4c05hlgDn4vKyY4zgn7szM2qHZcwf8Jh7SW5QWkyc1o/vCihUsI+ISR/qEFpHUGI6kck+ZUonNTpEFhBtHwuaAGmdBIzCeTijOVMMdozLrvEmeZ58+y66r8T/6W9pQlaoAXRYaDz1/JWYgw1reX1AA/EqwVSLsK6T5z+XomWAxZFSQdEnovgLtGvHmVVkx8lRpxZuLTPsfBeLtxDWzl983QGwqba7OsO6ZY+k2oXXDXWDpkiOT2nr8l8i4dxIsdIK3nDvallVoZiBLhZtRtnjuftDuvO+R4ssbtdHWhPnTic4lgGg3IAMQZLmG0yHxI7EFK2cKLj4GuIt8MP17GfRaHF8KzsdUpP8AeaQ0GCLiZEyLd0px2BPjezwuDoAgs1dlDZtzaZJ3SY5Oqs0ppk+H8AzGCKkxMBj9PNv4plQ4IwEEwwX8VRzWkx0JcfQJDRruAOZzzEzd+UEagEvElda8e8yZRcSJubOIOp1sfkmlCT7YrTfyahnEKbL0mmqcwJeQRSnd17vIvqrq2LfnL3ul2k8ujRsFk85mXOiNI3uCB6G07rRYioxt3Ttr+vRX+LilJtLopzRhjSb7IPqlninW+vzE9DuknEeM1KjrSQOWwH0VPGa5qBwa7TxDqNCPLwmOhSnDYmqwEAAzzXWhia3Wzn5MsXqwsUnVjIsE7wXDgwZtTshOCCQ0ExfXktNxfhNOlTzNqlzpFiQQe0aLY88MUowfb6OW8UsicvoSPLiVwsPJTgqmpiCCtHqGf0y+m+Pslee7oVLD8QadlM1S9zWtFyYHcpnlSVsVYbdIXcd8OHqu0IYY7m34r5eachfVP2g8Lq0sG55e0jMwEAEHxOAtzXyomFnx+Tjzx5Y3a6LJYZYnUimpIOqlmVdY3UkWRI2jmbkqLhZFHdV1NEoQWbrxqHVWlQcgEc08VnY1/wBptj1C7xXCCozOwXGvUIHh+j+ycYD4VVJ1I2Y0p42mKvZ7D+IvPwi3co/iplkcyp4f4FZW2VplXRlqzHNvBjnFvmqm13bFa7Hf+Xd3WX+0O4RIdfXMRy/R9VCvWIA6qxyqxejVANlQxB5ow1BCAq7K7YIpihNNwOilrY72PmquHbq6pqnQGzNNlri0+fMESLKdXG5ZyzJ3+pHLT6q/HfzXeX0CFxWoVUoosjJgbRMDzKniask+Q+qso/F5BVv1PdQNkajrQuF11YVFANljat0ww+MSwoilsqpwTNeDK0x7huN1GfC6By2TFnto+MrxmBm2b6AzCzCpqLLLw8U+0b/y8kTc4b2iAaGtbB12ETzvHK6VcQ9oXlxa5pBB3ABG+kWQFPTyU+PaUP8A6h9Slj4eJO6G/Mm4tnsPxd76rbxJAtqRmEjnzWlxHF3OEOYQDusXwf8An0/9bf8A9BbXEb91uxY4wXtOd5PkSm1yKeF/zWkiW79jY+id18LTLTAEqHDfhTCtor4JIxzk2LcFQgQUV7lo3XV4JmJya+SOTqq34ed1dsuBRbFboHGEUThXSCHRCNXCo0uiW1szntrWqmg0VKpc3OLE7gG6wbmrb+3f8ln+v8FiyhCEYKoqhsmSWR3J2A1iJU5Xauqkg2LR/9k=")
            .into(binding.strange)
        Glide.with(this@StrangeActivity)
            .asGif()
            .load("https://media.tenor.com/images/41f9e5c3c3375e9e2fa29b4539ff0233/tenor.gif")
            .into(binding.suitup)

        binding.doctor.setOnClickListener{
            onBackPressed()
        }
    }
}