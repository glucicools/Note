package com.gloria.note

import ViewModels.MainActivityViewModel
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gloria.note.NoteAdapter.NoteAdapter
import java.sql.DatabaseMetaData

class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding
    private lateinit var database: Notedatabase
    Private lateinit var noteAdapter: NoteAdapter
    private lateinit var :MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//Instantiating database
        database = Notedatabase.getInstance(applicationContext)

        //instantiating viewmodels
        ViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.getNotes(database)

        //observe live data from view model
        viewModel.notesLivesData.observe(this {notes ->
            noteAdapter = NoteAdapter(notes){
                val intent = Intent( thisMainActivity, NotesDetailActivity::class.java)
                intent.run{
                    putExtra("id,it.id")
                    startActivity(this)
                }
            }

        })

        noteAdapter = NoteAdapter(database.noteDao().getAllNotes())
        binding.notesRecycler.apply{
             layoutManager = LinearLayoutManager(this@MainActivity)
             adapter = noteAdapter
        }
        binding.saveBotton.setOnClickListner
        val title = binding.titleName.text.toString()
        val content = binding.contentName.text.toString()
        saveNote(title, content)
    }

    private fun saveNote(title: String, content: String){
        val note = Note(id = 0, title, content)
        viewModel.addNote(database, note)
    }
    private val listener = object : NoteAdapter.OnNoteItemClickListener{
        Override fun OnClick(note: Note){
            val intent = Intent(packageContextthis)
        }
    }
}




