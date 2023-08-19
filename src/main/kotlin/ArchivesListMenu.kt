class ArchivesListMenu(private val archiveMenu: ArchiveMenu) : Menu("-----Список архивов-----") {
    private var selectedArchive: String? = null

    init {
        addArchivesAsOptions()
        addOption("Назад", ::backToArchiveMenu)
    }

    private fun addArchivesAsOptions() {
        for ((archiveName, _) in archiveMenu.archives) {
            addOption(archiveName, { selectArchive(archiveName) })
        }
    }

    private fun selectArchive(archiveName: String) {
        selectedArchive = archiveName

        if (archiveMenu.archives.containsKey(selectedArchive)) {
            val noteMenu = NoteMenu(selectedArchive!!, archiveMenu.archives[selectedArchive]!!)
            noteMenu.execute()
        } else {
            println("Выбранный архив '$selectedArchive' не существует.")
        }
    }

    override fun execute() {
        start()
    }

    private fun backToArchiveMenu() {
        selectedArchive = null
        archiveMenu.execute()
    }
}