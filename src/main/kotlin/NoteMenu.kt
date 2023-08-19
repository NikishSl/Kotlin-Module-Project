class NoteMenu(private val archiveName: String, val archiveNotes: MutableList<Pair<String, String>>) : Menu("---Заметки в архиве '$archiveName'---") {

    init {
        addOption("Создать заметку", ::createNote)
        addOption("Список заметок", ::showNotesList)
        addOption("Назад", ::back)
    }

    override fun execute() {
        start()
    }

    private fun createNote(){
        val noteTitle = readInput("Введите название заметки: ")
        val noteContent = readInput("Введите содержимое заметки: ")

        noteTitle.let { title ->
            noteContent.let { content ->
                archiveNotes.add(Pair(title, content))
                println("Заметка названием '$title' создана в архиве '$archiveName'.")
            }
        }
    }

    private fun showNotesList() {
        if (archiveNotes.isEmpty()) {
            println("В архиве '$archiveName' нет заметок!!!")
        } else {
            val notesListMenu = NotesListMenu(this)
            notesListMenu.execute()
        }
    }

    private fun back() {}
}