package com.example.lateroomdb.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.lateroomdb.R
import com.example.lateroomdb.db.Note
import com.example.lateroomdb.db.NoteDatabase
import kotlinx.android.synthetic.main.fragment_add_note.*
import kotlinx.coroutines.launch


class AddNoteFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_save.setOnClickListener{view ->
            var noteTitle = title.text.toString().trim()
            var note = txt.text.toString().trim()

            if (noteTitle.isNullOrEmpty()){
                title.setError("note title is needed please!!")
                title.requestFocus()
                return@setOnClickListener
            }

            if (note.isNullOrEmpty()){
                txt.setError("note title is needed please!!")
                txt.requestFocus()
                return@setOnClickListener
            }

            launch {
                val notes = Note(noteTitle,note)
                context?.let {
                    NoteDatabase(it).getNoteDao().addNote(notes)
                    it.toast("Note saved")

                    val action = AddNoteFragmentDirections.actionAddNoteFragmentToHomeFragment()
                    Navigation.findNavController(view).navigate(action )
                }
            }

        }


    }


}
