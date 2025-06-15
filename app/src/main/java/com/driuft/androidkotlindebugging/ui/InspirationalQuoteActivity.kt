package com.driuft.androidkotlindebugging.ui // Replace with your actual package name

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.driuft.androidkotlindebugging.R
import kotlin.random.Random // Make sure this import is present

class InspirationalQuoteActivity : AppCompatActivity() {

    private lateinit var quoteTextView: TextView
    private lateinit var refreshQuoteButton: Button

    // Option 1: Using quotes from strings.xml (Recommended)
    private lateinit var inspirationalQuotes: List<String>

    // Option 2: Hardcoding quotes (Less flexible)
    // private val inspirationalQuotes_hardcoded = listOf(
    //     "The only way to do great work is to love what you do. - Steve Jobs",
    //     "Strive not to be a success, but rather to be of value. - Albert Einstein",
    //     // ... more quotes
    // )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inspirational_quote)

        quoteTextView = findViewById(R.id.quoteTextView)
        refreshQuoteButton = findViewById(R.id.refreshQuoteButton)

        // Initialize quotes (using Option 1 from strings.xml)
        val quotesArray = resources.getStringArray(R.array.inspirational_quotes)
        inspirationalQuotes = quotesArray.toList()

        // If using Option 2 (hardcoded list), uncomment the next line and comment out the two lines above
        // inspirationalQuotes = inspirationalQuotes_hardcoded

        displayRandomQuote()

        refreshQuoteButton.setOnClickListener {
            displayRandomQuote()
        }
    }

    private fun displayRandomQuote() {
        if (inspirationalQuotes.isNotEmpty()) {
            val randomIndex = Random.nextInt(inspirationalQuotes.size)
            quoteTextView.text = inspirationalQuotes[randomIndex]
        } else {
            quoteTextView.text = "No quotes available." // Fallback message
        }
    }
}