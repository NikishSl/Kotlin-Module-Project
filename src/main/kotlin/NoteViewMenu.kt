class NoteViewMenu(noteTitle: String, noteContent: String) : Menu("Название заметки: $noteTitle") {
    init {
        println("Содержание заметки: $noteContent")
        addOption("Назад", ::notesListMenu)
    }

    override fun execute() {
        start()
    }

    private fun notesListMenu() {}
}