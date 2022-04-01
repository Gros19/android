package com.example.slideapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.slideapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    //lazy를 사용해서 처음 호출될 때 초기화 되도록 설정
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentList = listOf(FavoriteFragment(), HomeFragment(), ProfileFragment())
        val adapter = FragmentStateAdapter(this)
        adapter.fragments = fragmentList

        /*activity_main.xml id/vPager2에 어뎁터 연결*/
        binding.viewPager2.adapter = adapter


    }

}

//
//    inner class ViewPagerAdapter  : PagerAdapter(){
//        override fun getCount() = viewList.size
//
//        /* view와 object가 같으면 true 리턴*/
//        override fun isViewFromObject(view: View, `object`: Any) = (view == `object`)
//
//        /*페이지를 넘길때마다 생성*/
//        override fun instantiateItem(container: ViewGroup, position: Int): Any {
//            /*현재 view를 가져와서, 현재 view는 ViewList의 position*/
//            var curView = viewList[position]
//            binding.viewPager2.addView(curView)
//            return curView
//        }
//
//        /*여기서 `object`는 사라질 오브젝트*/
//        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//            /*그것을 view형식으로 변환한 다음*/
//            /*removeView*/
//            binding.viewPager2.removeView(`object` as View)
//        }
//
//    }



