import java.util.Scanner

abstract class Menu(private val title: String) {
    private val options = mutableListOf<Pair<String, () -> Unit>>()

    fun addOption(optionTitle: String, action: () -> Unit){
        options.add(Pair(optionTitle, action))
    }

    open fun display(){
        println(title)
        for ((index, option) in options.withIndex()){
            println("${index + 1}. ${option.first}")
        }
    }

    abstract fun execute()

    fun start(){
        while (true){
            display()
            println("Выберете вариант: ")
            val optionIndex = readNumericOptionIndex()
            if (optionIndex == options.size){
                break
            }
            options[optionIndex - 1].second.invoke()
        }
    }

    fun readInput(message: String): String{
        while (true){
            println(message)
            val input = readlnOrNull()?.trim()

            if (input.isNullOrBlank()){
                println("Недопустимый ввод!!!")
            } else {
                return input
            }

        }
    }

    private fun readNumericOptionIndex(): Int {
        val scanner = Scanner(System.`in`)
        while (true){
            val input = scanner.nextLine()
            val number = input.toIntOrNull()

            if (number != null && number >= 1 && number <= options.size){
                return number
            } else {
                println("Введите верный номер пункта меню!!!")
            }
        }
    }

    fun exit() {}

}