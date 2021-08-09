import scala.io.StdIn._

object CCipher {
def main(args: Array[String]) {
    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    val E = (c:Char, shift:Int, a:String) => a((a.indexOf(c.toUpper)+shift)%a.size)
    val D = (c:Char, shift:Int, a:String) => a((a.indexOf(c.toUpper)-shift)%a.size)

    val cipher = (algo :(Char, Int, String) => Char, s:String, shift:Int, a:String) => s.map(c=> if (c==' ') c else algo(c,shift,a))
   
    println("--------- Caeser Cipher ---------")
    println("Your Options")
    println("\t 1 - Encrypt the Text")
    println("\t 2 - Decrypt the Text")
    println("Enter your Option: ")
    val o = readInt()

    var s = scala.io.StdIn.readLine("Enter the text: ")
    print("Enter Shift count: ")
    var shift = readInt()
   
    if(o == 1){
        var ans = cipher(E,s,shift,alphabet)
        println("Encrypted Text: " + ans)
    }
    else{
        var ans = cipher(D,s,shift,alphabet)
        println("Decrypted Text: " + ans)
    }

    }
}