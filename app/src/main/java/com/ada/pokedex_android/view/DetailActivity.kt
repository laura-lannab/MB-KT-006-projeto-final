package com.ada.pokedex_android.view

import androidx.appcompat.app.AppCompatActivity
import com.ada.mb_kt_006_projeto_final.R
//import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

/*    private lateinit var binding: CharDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.char_detail)

        val name: String = intent.extras!!.getString("name", "")
        val gender: String = intent.extras!!.getString("gender", "")
        val location: String = intent.extras!!.getString("location", "")
        val status: String = intent.extras!!.getString("status", "")
        val origin: String = intent.extras!!.getString("origin", "")
        val species: String = intent.extras!!.getString("species", "")
        val image: String = intent.extras!!.getString("image", "")

        binding.tvName.text = name
        binding.tvGender.text = gender
        binding.tvLocation.text = location
        binding.tvStatus.text = status
        binding.tvOrigin.text = origin
        binding.tvSpecie.text = species

        when (status) {
            "Alive" -> binding.ivStatus.setImageDrawable(
                resources.getDrawable(
                    R.drawable.status_alive,
                    null
                )
            )
            "Dead" -> binding.ivStatus.setImageDrawable(
                resources.getDrawable(
                    R.drawable.status_death,
                    null
                )
            )
            "unknow" -> binding.ivStatus.setImageDrawable(
                resources.getDrawable(
                    R.drawable.status_unknow,
                    null
                )
            )
        }

        Glide
            .with(this)
            .load(image)
            .fitCenter()
            .placeholder(R.drawable.no_image)
            .into(binding.imageView)

        binding.back.backBtn.setOnClickListener {
            finish()
        }
    }*/

}