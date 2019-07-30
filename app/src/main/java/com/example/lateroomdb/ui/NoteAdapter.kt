package com.example.lateroomdb.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lateroomdb.R
import com.example.lateroomdb.db.Note
import kotlinx.android.synthetic.main.fragment_add_note.view.*
import kotlinx.android.synthetic.main.note_layout.view.*
import kotlinx.android.synthetic.main.note_layout.view.title

class NoteAdapter(val notes : List<Note>)  : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.note_layout,parent,false
                )

        )
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.view.title.text = notes[position].title
        holder.view.Note.text = notes[position].note

    }

    class NoteViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}