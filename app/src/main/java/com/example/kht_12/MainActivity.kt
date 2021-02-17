package com.example.kht_12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kht_12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
                id = 1,
                author = "Нетология. Меняем карьеру через образование",
                published = "21 мая 2020",
                content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
                likedByMe = false)

        with(binding) {
            postTextTV.setText(post.content)

            likeIV.setOnClickListener {
                if (!post.likedByMe) {
                    post.likedByMe = true
                    likeIV.setImageResource(R.drawable.ic_red_like)
                    post.amountOfLikes++
                } else {
                    post.likedByMe = false
                    likeIV.setImageResource(R.drawable.ic_empty_like)
                    post.amountOfLikes--
                }
                likeAmountTV.setText(viewDigitAmounts(post.amountOfLikes))
            }

            shareIV.setOnClickListener {
                post.amountOfShared++
                sharedAmountTV.setText(viewDigitAmounts(post.amountOfShared))
            }

            seenIV.setOnClickListener {
                post.amountOfSeen++
                seenAmountTV.setText(viewDigitAmounts(post.amountOfSeen))
            }

            likeAmountTV.setText(post.amountOfLikes.toString())
            seenAmountTV.setText(post.amountOfSeen.toString())
            sharedAmountTV.setText(post.amountOfShared.toString())
        }
    }

}


fun viewDigitAmounts(amount: Int): String = when (amount) {
    in 0..999 -> amount.toString()
    in 1000..999_999 -> (amount / 1000).toString() + "К"
    else -> (amount / 1_000_000).toString() + "M"
}
