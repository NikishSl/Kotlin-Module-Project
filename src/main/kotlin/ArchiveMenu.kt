class ArchiveMenu : Menu("-----Архивы-----") {
    private val archives = mutableMapOf<String, MutableList<Pair<String, String>>>()

    init {
        addOption("Добавить архив", ::addArchive)
        addOption("Список архивов", ::listArchives)
        addOption("Выбрать архив", ::selectArchive)
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

    private fun listArchives(){
        if (archives.isEmpty()){
            println("Нет доступных архивов!!!")
        } else {
            println("Доступные архивы: ")
            for (archive in archives.keys){
                println(archive)
            }
        }
    }

    private fun selectArchive(){
        if (archives.isEmpty()){
            println("Нет доступных архивов!!!")
        } else {
            val selectedArchive = readInput("Выберете архив для работы: ")
            selectedArchive.let {
                if (archives.containsKey(it)){
                    val noteMenu = NoteMenu(it, archives[it]!!)
                    noteMenu.execute()
                } else {
                    println("Выбранный архив '$it' не существует.")
                }
            }
        }
    }

    private fun exitArchive(){
        exit()
    }

}