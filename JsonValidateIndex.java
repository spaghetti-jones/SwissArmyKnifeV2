public class JsonValidateIndex extends HttpRequest{
    public Boolean parseIndex() {
        for (String line : urlContent) {
            parseLine(line);
        }
        return true;
    }
    
    private void parseLine(String line) {
        String[] subString = line.split("\"");

        if (subString.length > 11) { //subString[11] is the contactURL.
            JsonValidateIndex requestIndex = new JsonValidateIndex();
    
            if (subString[9].equals("ContactURL")) {
                String contactURL = subString[11];
    
                System.out.println("\nURL: " + contactURL);
                requestIndex.readURL(contactURL);
                System.out.println(requestIndex);
                JsonValidateIndex requestIndex2 = new JsonValidateIndex();
                if (requestIndex2.readURL(contactURL)) {
                    if (subString.length > 1) {
                        if (subString[1].equals("firstName")) {
                            String firstName = subString[3];
                            System.out.println("\nFirst Name is " + firstName);
                        }
                    }
                }
            }
        }
    }
}