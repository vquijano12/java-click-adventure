package Event;

import Main.GameManager;

public class Event01 {
    GameManager gm;
    boolean cornerExamined = false;

    public Event01(GameManager gm) {
        this.gm = gm;
    }

    public void lookCorner() {
        gm.ui.messageText.setText("Hmmm...");
    }

    public void examineCorner() {
        gm.ui.messageText.setText("What's that? It looks like something hidden behind the bookcase.");
        cornerExamined = true;
        updateChoices();
    }

    public void nothingCorner() {
        gm.ui.messageText.setText(".....");
    }

    public void lookBookcase() {
        gm.ui.messageText.setText("Nice looking bookcase, I guess.");
    }

    public void examineBookcase() {
        gm.ui.messageText.setText("Something feels a little off about this...");
    }

    public void pushOrPunchBookcase() {
        if (cornerExamined) {
            gm.ui.messageText.setText("Impressive! You moved the bookcase.");
            gm.sChanger.showScene4();
        } else {
            gm.ui.messageText.setText("OUCH!! That's one tough bookcase, better be careful.");
        }
    }

    private void updateChoices() {
        // Update the choices based on the current state
        if (cornerExamined) {
            gm.ui.menuItem[3].setText("Push");
        } else {
            gm.ui.menuItem[3].setText("Punch");
        }
    }
}
