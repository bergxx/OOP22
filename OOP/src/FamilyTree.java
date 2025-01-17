import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

    private List<Human> family;

    public FamilyTree() {
        this.family = new ArrayList<>();
    }

    public void addMember(Human member) {
        if (member != null) {
            this.family.add(member);
        }
    }

    public List<Human> getFamily() {
        return this.family;
    }

    public String allMembers() {
        StringBuilder output = new StringBuilder("Члены семьи:\n");
        for (Human member : family) {
            output.append("...................................\n")
                  .append("Имя: ").append(member.getName()).append("\n")
                  .append("Дата рождения: ").append(member.getDob()).append("\n")
                  .append("Пол: ").append(member.getGender() == Gender.Male ? "Мужской" : "Женский").append("\n");
        }
        return output.toString();
    }

    public String allChildren(Human person) {
        if (person == null) {
            return "Персона не найдена.";
        }
        StringBuilder children = new StringBuilder("Ребенок " + person.getName() + "\n");
        boolean found = false;
        for (Human member : family) {
            if ((member.getMother() != null && member.getMother().equals(person)) ||
                (member.getFather() != null && member.getFather().equals(person))) {
                found = true;
                children.append("...................................\n")
                        .append("Имя: ").append(member.getName()).append("\n")
                        .append("Дата рождения: ").append(member.getDob()).append("\n")
                        .append("Пол: ").append(member.getGender() == Gender.Male ? "Мужской" : "Женский").append("\n");
            }
        }
        if (!found) {
            children.append("Дети отсутствуют.");
        }
        return children.toString();
    }
}