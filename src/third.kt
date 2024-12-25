import java.io.File

fun thirdA() : Int{
    val filePath = "src/files/3.txt"
    var content = File(filePath).readText()
    content+="...."

    val isStart = false
    val word = "mul("
    var onTrack = false
    var first = ""
    var second = ""
    var temp = ""
    var separatorCounter = 0
    var out = 0

    var i = 0

    while (i < content.length - 4) {

        if(onTrack){
            if (content[i] == ','){
                first = temp+""
                separatorCounter +=1
                temp = ""

            } else if (content[i] in '0'..'9'){
                temp += content[i]
            } else if (content[i] == ')'){
                second = temp+""

                if (
                    first != "" &&
                    second != "" &&
                    separatorCounter == 1
                ){
                    out += first.toInt() * second.toInt()
                }
                onTrack = false
                temp = ""
                first = ""
                second = ""
                separatorCounter = 0

            }else{
                onTrack = false
                temp = ""
                first = ""
                second = ""
                separatorCounter = 0
            }
        }

        if (content.substring(i, i + 4) == word) {
            i += 4
            onTrack = true

        } else {
            i++
        }
    }

    return out
}


fun thirdB() : Int{
    val filePath = "src/files/3.txt"
    var content = File(filePath).readText()
    content+="..................."

    val isStart = false
    val word = "mul("
    var onTrack = false
    var first = ""
    var second = ""
    var temp = ""
    var separatorCounter = 0
    var out = 0
    var dont = false

    var i = 0

    while (i < content.length - 7) {

        if (dont){

        }else if(onTrack){
            if (content[i] == ','){
                first = temp+""
                separatorCounter +=1
                temp = ""
            } else if (content[i] in '0'..'9'){
                temp += content[i]
            } else if (content[i] == ')'){
                second = temp+""

                if (
                    first != "" &&
                    second != "" &&
                    separatorCounter == 1
                ){

                    out += first.toInt() * second.toInt()
                }

                onTrack = false
                temp = ""
                first = ""
                second = ""
                separatorCounter = 0

            }else{
                onTrack = false
                temp = ""
                first = ""
                second = ""
                separatorCounter = 0
            }
        }

        if (content.substring(i, i + 7) == "don't()") {
            dont = true
            i++
        }else if (content.substring(i, i + 4) == "do()") {
            dont = false
            i++
        }else if (content.substring(i, i + 4) == word) {
            i += 4
            onTrack = true
        } else {
            i++
        }
    }

    return out
}





