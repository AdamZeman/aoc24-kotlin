import java.io.File

fun secondA() : Int{
    val filePath = "src/files/2.txt"
    val content = File(filePath).readText()
    val rows = content.split("\n").filter { it.trim().isNotEmpty() }
    val splittedRows = rows.mapNotNull { line ->
        val parts = line.trim().split(" ").filter { it.isNotBlank() }

        if (parts.isNotEmpty()) {
             parts.map { it.toInt() }
        }else{
            null
        }
    }

    val counterDec = splittedRows.filter{row ->
        var pairs =  row zip row.drop(1)
        pairs.all { it.first -1 == it.second ||  it.first -2 == it.second||  it.first -3 == it.second}
    }.count()

    val counterAcc = splittedRows.filter{row ->
        var pairs =  row zip row.drop(1)
        pairs.all { it.first +1 == it.second ||  it.first +2 == it.second||  it.first +3 == it.second}
    }.count()



    return counterDec + counterAcc
}

fun secondB() : Int{
    val filePath = "src/files/2.txt"
    val content = File(filePath).readText()
    val rows = content.split("\n").filter { it.trim().isNotEmpty() }
    val splittedRows = rows.mapNotNull { line ->
        val parts = line.trim().split(" ").filter { it.isNotBlank() }

        if (parts.isNotEmpty()) {
            parts.map { it.toInt() }
        }else{
            null
        }
    }

    val counterDec = splittedRows.filter{row ->

        for (i in -1 until row.size){
            val mutableRow = row.toMutableList()
            if (i>-1){
                mutableRow.removeAt(i)
            }
            var pairs =  mutableRow zip mutableRow.drop(1)
            val isCorrect = pairs.all { it.first -1 == it.second ||  it.first -2 == it.second||  it.first -3 == it.second}

            if (isCorrect){
                return@filter true
            }
        }
        false
    }.count()

    val counterAcc = splittedRows.filter{row ->

        for (i in -1 until row.size){
            val mutableRow = row.toMutableList()
            if (i>-1){
                mutableRow.removeAt(i)
            }
            var pairs =  mutableRow zip mutableRow.drop(1)
            val isCorrect = pairs.all { it.first +1 == it.second ||  it.first +2 == it.second||  it.first +3 == it.second}

            if (isCorrect){
                return@filter true
            }
        }
        false
    }.count()



    return counterDec + counterAcc
}