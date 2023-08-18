class NoteMenu(private val archiveName: String, private val archiveNotes: MutableList<Pair<String, String>>) : Menu("---Заметки в архиве '$archiveName'---") {

    init {
        addOption("Создать заметку", ::createNote)
        addOption("Выбрать заметку", ::selectNote)
        addOption("Посмотреть все заметки", ::listNote)
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

    private fun selectNote(){
        val noteTitle = readInput("Введите название заметки: ")
        val selectedNote = archiveNotes.find { it.first == noteTitle }

        if (selectedNote != null){
            println("Выбрана заметка '${selectedNote.first}' в архиве '$archiveName' \nСодержание: '${selectedNote.second}'")
        } else {
            println("Заметка с названием '$noteTitle' не найдена!!!")
        }
    }

    private fun listNote(){
        if (archiveNotes.isEmpty()){
            println("В архиве '$archiveName' нет заметок!!!")
        } else {
            println("Список заметок в архиве '$archiveName': ")
            for ((index, note) in archiveNotes.withIndex()){
                println("${index + 1}. Название: ${note.first}")
            }
        }
    }

    private fun back() {}
}