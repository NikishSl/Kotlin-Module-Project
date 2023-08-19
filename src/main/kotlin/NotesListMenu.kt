class NotesListMenu(private val noteMenu: NoteMenu) : Menu("-----Список заметок-----") {
    init {
        addNotesAsOptions()
        addOption("Назад", ::backToNoteMenu)
    }

    private fun addNotesAsOptions() {
        for ((index, note) in noteMenu.archiveNotes.withIndex()) {
            addOption(note.first, { viewNote(index) })
        }
    }

    private fun viewNote(noteIndex: Int) {
        val selectedNote = noteMenu.archiveNotes[noteIndex]
        val noteViewMenu = NoteViewMenu(selectedNote.first, selectedNote.second)
        noteViewMenu.execute()
    }

    override fun execute() {
        start()
    }

    private fun backToNoteMenu() {
        noteMenu.execute()
    }
}