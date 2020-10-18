package seedu.address.model.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.ReadOnlyReeve;
import seedu.address.model.Reeve;
import seedu.address.model.student.*;
import seedu.address.model.student.admin.AdditionalDetail;
import seedu.address.model.student.admin.Admin;
import seedu.address.model.student.admin.ClassTime;
import seedu.address.model.student.admin.ClassVenue;
import seedu.address.model.student.admin.Fee;
import seedu.address.model.student.admin.PaymentDate;


/**
 * Contains utility methods for populating {@code Reeve} with sample data.
 */
public class SampleDataUtil {
    public static Student[] getSamplePersons() {
        return new Student[] {
            new Student(new Name("Alex Yeoh"), new Phone("87438807"),
                    new School("NUS High School"), new Year(SchoolType.SECONDARY, 4),
                    new Admin(new ClassVenue("Blk 30 Geylang Street 29, #06-40"),
                            new ClassTime("1 1400-1500"), new Fee("430"),
                            new PaymentDate("23/4/19"), getDetailSet("clever")),
                    getQuestions("How do birds fly?")),
            new Student(new Name("Bernice Yu"), new Phone("99272758"),
                    new School("Montford Secondary School"), new Year(SchoolType.SECONDARY, 4),
                    new Admin(new ClassVenue("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                            new ClassTime("1 1500-1600"), new Fee("50"),
                            new PaymentDate("30/6/20"), getDetailSet()),
                    getSolvedQuestions("Explain heat flow.")),
            new Student(new Name("Charlotte Oliveiro"), new Phone("93210283"),
                    new School("Raffles Girls School"), new Year(SchoolType.SECONDARY, 3),
                    new Admin(new ClassVenue("Blk 11 Ang Mo Kio Street 74, #11-04"),
                            new ClassTime("2 1900-1930"), new Fee("680"),
                            new PaymentDate("1/12/19"), getDetailSet()),
                    getQuestions()),
            new Student(new Name("David Li"), new Phone("91031282"),
                    new School("Anderson Primary School"), new Year(SchoolType.PRIMARY, 2),
                    new Admin(new ClassVenue("Blk 436 Serangoon Gardens Street 26, #16-43"),
                            new ClassTime("6 0800-0950"), new Fee("12"),
                            new PaymentDate("24/7/20"), getDetailSet("friend")),
                    getQuestions("How do birds fly?", "Explain heat flow.")),
            new Student(new Name("Irfan Ibrahim"), new Phone("92492021"),
                    new School("National Junior College"), new Year(SchoolType.JC, 1),
                    new Admin(new ClassVenue("Blk 47 Tampines Street 20, #17-35"),
                            new ClassTime("3 1300-1400"), new Fee("0"),
                            new PaymentDate("7/4/20"), getDetailSet("clever", "friend")),
                    getQuestions()),
            new Student(new Name("Roy Balakrishnan"), new Phone("92624417"),
                    new School("Catholic High School"), new Year(SchoolType.JC, 1),
                    new Admin(new ClassVenue("Blk 45 Aljunied Street 85, #11-31"),
                            new ClassTime("4 2000-2130"), new Fee("38"),
                            new PaymentDate("19/12/19"), getDetailSet("rude")),
                    getQuestions())
        };
    }

    public static ReadOnlyReeve getSampleAddressBook() {
        Reeve sampleAb = new Reeve();
        for (Student sampleStudent : getSamplePersons()) {
            sampleAb.addStudent(sampleStudent);
        }
        return sampleAb;
    }

    /**
     * Returns a {@code AdditionalDetail} set containing the list of given strings.
     */
    public static Set<AdditionalDetail> getDetailSet(String... strings) {
        return Arrays.stream(strings)
                .map(AdditionalDetail::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a {@code Question} list containing the list of given strings.
     */
    public static List<Question> getQuestions(String... strings) {
        return Arrays.stream(strings)
                .map(Question::new)
                .collect(Collectors.toList());
    }

    /**
     * Returns a list of solved {@code Questions} containing the given strings.
     */
    public static List<Question> getSolvedQuestions(String... strings) {
        return Arrays.stream(strings)
                .map(string -> new Question(string, true))
                .collect(Collectors.toList());
    }

}
