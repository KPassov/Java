public class Simulation
{
  private DikuPlus network;
  private Person kasper, knud, ole;

  public static void main(String[] args)
  {
    new Simulation();
  }

  private Simulation()
  {
    this.network = new DikuPlus();
    this.generatePeople();
    this.makeFriends();
    this.addPeopleToTheNetwork(new Person[] { kasper, knud, ole });
    this.makeConversation();
    network.report();
  }

  private void generatePeople()
  {
    kasper = new Person("kasper");
    knud = new Person("knud");
    ole = new Person("ole");
  }

  private void makeFriends()
  {
    this.knud.requestFriendship(this.ole);
    this.ole.requestFriendship(this.knud);
    this.kasper.requestFriendship(this.knud);
    this.kasper.requestFriendship(this.ole);
  }

  private void addPeopleToTheNetwork(Person[] people)
  {
    for (Person person : people)
      network.addPerson(person);
  }

  private void makeConversation()
  {
    this.knud.sendMessage(this.kasper, "How's it going?");
    this.kasper.sendMessage(this.knud, "All good!");

    this.ole.sendMessage(this.knud, "Anything interesting going on?");
    this.ole.sendMessage(this.kasper, "Anything interesting going on?");

    this.kasper.sendMessage(this.ole, "Yes!");
    this.knud.sendMessage(this.ole, "No.");

    this.ole.sendMessage(this.knud, "We should meet soon!");
    this.ole.sendMessage(this.kasper, "We should meet soon!");
  }
}