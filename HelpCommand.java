class HelpCommand {
    public static void helpOutput() {
        System.out.println("\nAn HttpRequest should be entered like the example shown below:");
		System.out.println("java sak -HttpRequest https://thunderbird-index.azurewebsites.net/w0a6zk195e.json");
		System.out.println("\nAn HttpRequestIndex should be entered like the example shown below:");
        System.out.println("java sak -HttpRequestIndex https://thunderbird-index.azurewebsites.net/w0a6zk195d.json");
        System.out.println("\nCommand must be entered twice by the user!");
        System.out.println("\nTo see this text again use the -Help command");
        System.out.println("\nYou can Copy and Paste one of the provided commands");
    }
}