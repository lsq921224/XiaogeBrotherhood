// Input:	csvformat
// John,Smith,john.smith@gmail.com,Los	Angeles,1
// Jane,Roberts,janer@msn.com,"San	Francisco,	CA",0
// "Alexandra	""Alex""",Menendez,alex.menendez@gmail.com,Miami,1	"""Alexandra	Alex"""
// Output:	escaped	string
// John|Smith|john.smith@gmail.com|Los	Angeles|1
// Jane|Roberts|janer@msn.com|San	Francisco,	CA|0
// Alexandra	"Alex"|Menendez|alex.menendez@gmail.com|Miami|1	"Alexandra	Alex"

// basically need to deal with empty string case. NO!!
// just deal with two quotes together, this is the escaping in CSV, and it that string has to be inQuote too.
public String parseCSV(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        boolean q = false;
        // started for the two double quotes  started, if the end of string is ", then it's okay to set it to be true, it doesn't matter
        boolean started = false;
        if (q) {
            started = true;
            if (c == '"') {
                q = false;
            } else {
                sb.append(c);
            }
        } else {
            if (c == '"') {
                if (started) {
                    // only the second of two double quotes exist then insert
                    sb.append('"');
                }
                q = true;
            } else if (c == ',') {
                res.add(sb.toString());
                sb.setLength(0);
            }
        }
    }
    if(sb.length() > 0) {
        res.add(sb.toString());
    }
    return String.join("|", res);
}
