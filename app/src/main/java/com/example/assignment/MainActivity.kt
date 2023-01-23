package com.example.assignment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment.Api.RetrofitInstance
import com.example.assignment.model.Tag
import com.example.assignment.model.TopTagResponse
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var islistexpended: Boolean = false

    private lateinit var tagList: List<Tag>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val response = RetrofitInstance.api.getTopTags()
Toast.makeText(this,"loading...",Toast.LENGTH_SHORT).show()

        response.enqueue(
            object : retrofit2.Callback<TopTagResponse> {
                override fun onResponse(
                    call: retrofit2.Call<TopTagResponse>,
                    response: retrofit2.Response<TopTagResponse>
                ) {
                    if (response.body() != null) {

                        val topTags = (response.body())!!
                        tagList = topTags.toptags.tag
                        refreshtheList()


                    }
                }

                override fun onFailure(call: retrofit2.Call<TopTagResponse>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Ativity started ${t}", Toast.LENGTH_LONG)
                        .show()

                }

            },
        )


    }


    private fun refreshtheList() {
        if (islistexpended) {
            toggleIcon.setImageResource(R.drawable.ic_baseline_expand_less_24)
        } else {
            toggleIcon.setImageResource(R.drawable.ic_baseline_expand_more_24)
        }
        chipGroup.removeAllViews()
        for (i in 1 until tagList.size) {
            if (i == 10 && !islistexpended) {
                break
            }
            val tag = tagList[i]
            val chip = Chip(this)
            chip.text = tag.name

            chip.setChipBackgroundColorResource(R.color.chipcolor)

            chip.setOnClickListener {
                val intent = Intent(this, GenreDetailActivity::class.java)
                intent.putExtra("tag", tag.name)
                startActivity(intent)
            }
            chipGroup.addView(chip)
        }
    }

    fun buttonPressed(view: View) {
        islistexpended = !islistexpended
        refreshtheList()
    }
}



