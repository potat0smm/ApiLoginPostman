package com.example.apiloginpostman.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.apiloginpostman.R
import com.example.apiloginpostman.api.RetrofitClient
import com.example.apiloginpostman.databinding.ActivityMainBinding
import com.example.apiloginpostman.models.DefaultResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSignUp.setOnClickListener{

            val email = binding.editTextEmail.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()
            val name = binding.editTextName.text.toString().trim()
            val school = binding.editTextSchool.text.toString().trim()

            if(email.isEmpty()){
                binding.editTextEmail.error = "Email required"
                binding.editTextEmail.requestFocus()
                return@setOnClickListener
            }
            if(password.isEmpty()){
                binding.editTextPassword.error = "Password required"
                binding.editTextPassword.requestFocus()
                return@setOnClickListener
            }
            if(name.isEmpty()){
                binding.editTextName.error = "Name required"
                binding.editTextName.requestFocus()
                return@setOnClickListener
            }
            if(school.isEmpty()){
                binding.editTextSchool.error = "School required"
                binding.editTextSchool.requestFocus()
                return@setOnClickListener
            }

            RetrofitClient.instance.createUser( email, name, password, school)
                .enqueue(object: Callback<DefaultResponse>{

                    override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                        //Toast.makeText(applicationContext, "lol", Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(
                        call: Call<DefaultResponse>,
                        response: Response<DefaultResponse>
                    ) {
                        //Toast.makeText(applicationContext,"lol",Toast.LENGTH_LONG).show()
                    }



                })


        }




    }

}