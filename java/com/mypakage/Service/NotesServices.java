package com.mypakage.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypakage.DAO.NotesRepo;
import com.mypakage.Entity.Notes;

@Service
public class NotesServices {

	@Autowired
	private NotesRepo notesRepo;

	// `Add Notes

	/*
	 * public Notes Addnotes(Notes notes) {
	 * 
	 * Notes result= this.notesRepo.save(notes);
	 * 
	 * 
	 * return result;
	 * 
	 * }
	 */

	
	  
	  // fetch notes
	  
		/*
		 * public List<Notes> getAllNotes(){ List<Notes> notes=notesRepo.findAll();
		 * return notes;
		 */
//	  List<Notes> getAllNotes= (List<Notes>)this.notesRepo.findAll(); 
//	  return  getAllNotes;
	  
	  
//	  }
	 

	// update Notes

	public void updateNotes(Notes notes, int id) {

		notes.setId(id);

		this.notesRepo.save(notes);

	}

	// delete notes

	public void deleteNotes(int id) {

		this.notesRepo.deleteById(id);
	}

	// find by id notes

	public Notes findbyIdNotes(int id) {

		// Optional<Notes> optional=notesRepo.findById(id)

		// List<Notes> notes = this.notesRepo.findById(id);

		return null;

	}

}
