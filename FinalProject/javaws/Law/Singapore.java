class Singapore extends Law{
Singapore(){
    System.out.println("Welcome to Singapore");
}
@Override
    public void companyLaws() {
        System.out.println("Dress Code");
        System.out.println("Attendance");
    }
@Override
    public void civilLaws() {
        System.out.println("Civil Law Act");
    }
@Override
    public void criminalLaws() {
        System.out.println("No littering");
        System.out.println("No eating chewing gums");
    }
}