package com.dicoding.submission1_githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.submission1_githubuserapp.databinding.ActivityDetailUserBinding

class DetailUser : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "EXTRA_USER"
    }

    private lateinit var binding : ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        binding.apply {
            username.text = user.username
            name.text = user.name
            tvTotalRepo.text = user.repository
            tvTotalFollower.text = user.follower
            tvTotalFollowing.text = user.following
            company.text = user.company
            tvLocation.text = user.location
        }
        Glide.with(this)
            .load(user.avatar)
            .apply(RequestOptions.circleCropTransform())
            .into(binding.userAvatar)
    }
}