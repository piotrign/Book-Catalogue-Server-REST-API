package pl.coderslab.warsztat5.responsemsg;

public enum ResponseMsg {

    CREATED("Book has been added"),
	BOOKEXISTS("Could not add a new book"),
	BOOKDELETED("Book has been deleted successfully"),
	BOOKNOTFOUND("Book has been not found");
	
    private String desc;

    ResponseMsg(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
