package com.example.kht_12.repository

import android.provider.SyncStateContract.Helpers.update
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kht_12.activity.MainActivity
import com.example.kht_12.dto.Post

class PostRepositoryInMemoryImpl : PostRepository {

    var post = Post(
        id = 1,
        author = "Нетология. Меняем карьеру через образование",
        published = "21 мая 2020",
        content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
        likedByMe = false
    )

    private val data = MutableLiveData(post)

    override fun get(): LiveData<Post> = data
    override fun like() {
        data.value = post
        if (!post.likedByMe) {
            post = post.copy(likedByMe = !post.likedByMe, amountOfLikes = post.amountOfLikes + 1)
        } else {
            post = post.copy(likedByMe = !post.likedByMe, amountOfLikes = post.amountOfLikes - 1)
        }
    }

    override fun share() {
        post = post.copy(amountOfShared = post.amountOfShared + 1)
    }

    override fun see() {
        post = post.copy(amountOfSeen = post.amountOfSeen + 1)
    }
}