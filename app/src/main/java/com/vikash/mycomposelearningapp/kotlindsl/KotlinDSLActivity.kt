package com.vikash.mycomposelearningapp.kotlindsl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vikash.mycomposelearningapp.R

// For Kotlin DSL Legacy Support
/*import org.jetbrains.anko.button
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.padding
import org.jetbrains.anko.textView
import org.jetbrains.anko.toast
import org.jetbrains.anko.verticalLayout*/

class KotlinDSLActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_dsl)

        // For Kotlin DSL Legacy Support
        /*verticalLayout {
            padding = dip(16)

            textView {
                text = "Hello, Kotlin DSL!"
                textSize = 24f
            }.lparams(width = matchParent) {
                bottomMargin = dip(16)
            }

            button {
                text = "Click Me!"
                setOnClickListener { toast("Button Clicked!") }
            }.lparams(width = matchParent)
        }*/
    }
}