class ArchiveMenu : Menu("-----Архивы-----") {
    val archives = mutableMapOf<String, MutableList<Pair<String, String>>>()

    init {
        addOption("Добавить архив", ::addArchive)
        addOption("Показать список архивов", ::showArchivesList)
        addOption("Выход", ::exitArchive)
    }

    override fun execute() {
        start()
    }

    private fun addArchive(){
        val archiveName = readInput("Введите имя архива: ")
        archiveName.let {
            archives[it] = mutableListOf()
            println("Архив '$it' добавлен.")
        }
    }

    private fun showArchivesList() {
        if (archives.isEmpty()) {
            println("Нет доступных архивов!!!")
        } else {
            val archivesListMenu = ArchivesListMenu(this)
            archivesListMenu.execute()
        }
    }

    private fun exitArchive(){
        exit()
    }
}