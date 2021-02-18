package com.example.kht_12.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.observe
import com.example.kht_12.viewmodel.PostViewModel
import com.example.kht_12.R
import com.example.kht_12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        viewModel.postData.observe(this, { post ->

            with(binding) {
                postTextTV.setText(post.content)
                likeAmountTV.setText(viewDigitAmounts(post.amountOfLikes))

                likeIV.setImageResource(
                    if (post.likedByMe) R.drawable.ic_red_like else R.drawable.ic_empty_like
                )

                likeIV.setOnClickListener {
                    viewModel.like()
                }
            }
        })
    }
}


fun viewDigitAmounts(amount: Int): String = when (amount) {
    in 0..999 -> amount.toString()
    in 1000..999_999 -> (amount / 1000).toString() + "К"
    else -> (amount / 1_000_000).toString() + "M"
}
