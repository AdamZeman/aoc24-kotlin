import java.io.File

fun isValid(seq : List<String>, rules: List<String>) : Boolean {
    for (i in 0 until seq.size-1){
        for (j in i+1 until seq.size){
            val search = seq[i]+"|"+seq[j]
            if (search in rules){

            }else{
                return false
            }
        }
    }

    return true
}

fun fifthA() : Int{
    val filePath = "src/files/5.txt"
    val content = File(filePath).readText()

    val tabs = content.split(Regex("\\r?\\n\\r?\\n"))
    val rules = tabs[0].split("\r\n")
    val sequences = tabs[1].trim().split("\r\n")
    val newSequences = sequences.map{
        it.split(",")
    }

    var counter = 0
    for (seq in newSequences){
        println(seq+" ha")
        if (isValid(seq,rules)){
            counter += seq[seq.size/2 ].toInt()
        }
    }
    println(counter)
    return 0
}

fun fifthB() : Int{
    val filePath = "src/files/5.txt"
    val content = File(filePath).readText()
    val tabs = content.split(Regex("\\r?\\n\\r?\\n"))
    val rules = tabs[0].split("\r\n")
    val sequences = tabs[1].trim().split("\r\n")
    val newSequences = sequences.map{
        it.split(",")
    }

    var counter = 0

    for (seq in newSequences){
        println(seq+" ha")
        if (isValid(seq,rules)){

        }else{
            val customSortedNumbers = seq.sortedWith(Comparator { a, b ->
                val search = a+"|"+b
                if (search in rules){
                    1
                }else{
                    -1
                }
                }
            )

            counter += customSortedNumbers[customSortedNumbers.size/2 ].toInt()
        }
    }

    println(counter)

    return 0
}