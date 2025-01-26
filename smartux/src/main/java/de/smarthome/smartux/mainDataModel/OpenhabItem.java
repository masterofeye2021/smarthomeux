package de.smarthome.smartux.mainDataModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class OpenhabItem {
    private String type;
    private String name;
    private String label;
    private String category;
    private List<String> tags;
    private List<String> groupNames;
    private String link;
    private String state;
    private String transformedState;
    private StateDescription stateDescription;
    private String unitSymbol;
    private CommandDescription commandDescription;
    private Metadata metadata;
    private boolean editable;

    // Getter und Setter für alle Felder

    @Data
    public static class StateDescription {
        private int minimum;
        private int maximum;
        private int step;
        private String pattern;
        private boolean readOnly;
        private List<Option> options;

        // Getter und Setter für alle Felder

        public static class Option {
            private String value;
            private String label;

            // Getter und Setter für alle Felder
        }
    }

    @Data
    public static class CommandDescription {
        private List<CommandOption> commandOptions;

        // Getter und Setter für alle Felder

        public static class CommandOption {
            private String command;
            private String label;

            // Getter und Setter für alle Felder
        }
    }

    @Data
    public static class Metadata {
        private Map<String, Object> smartux = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Name:" + this.name + "[type: " + this.type + "," + this.link + "]";
    }

    @Override
    public int hashCode() {
        return (int) name.hashCode() * label.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (obj.getClass() != this.getClass())
            return false;
        OpenhabItem item = (OpenhabItem) obj;
        return this.name.equals(item.getName());
    }
}
