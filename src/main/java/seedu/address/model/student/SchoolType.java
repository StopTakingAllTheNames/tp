package seedu.address.model.student;

import seedu.address.logic.parser.exceptions.ParseException;

import java.util.Map;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public enum SchoolType {

    PRIMARY {
        @Override
        public String toString() {
            return "Primary";
        }
    },
    SECONDARY {
        @Override
        public String toString() {
            return "Secondary";
        }
    },
    JC {
        @Override
        public String toString() {
            return "JC";
        }
    };

    public static final String SCHOOL_TYPE_CONSTRANTS = "The type"
            + "of school can only be one of \"secondary\", \"Secondary\", \"sec\", \"Sec\", \"s\", \"S\""
            + "\"primary\", \"Primary\", \"pri\", \"Pri\", \"p\", \"P\", "
            + "\"jc\", \"Jc\", \"JC\", \"j\", \"J\"";

    public static final Map<String, SchoolType> lookupTable = Map.ofEntries(
            Map.entry("pri", PRIMARY),
            Map.entry("primary", PRIMARY),
            Map.entry("p", PRIMARY),
            Map.entry("sec", SECONDARY),
            Map.entry("secondary", SECONDARY),
            Map.entry("s", SECONDARY),
            Map.entry("jc", JC),
            Map.entry("j", JC)
    );

    public static boolean isValidSchoolType(String schoolType) {
        return lookupTable.containsKey(schoolType.toLowerCase());
    }

}