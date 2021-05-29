package by.mybot.payment.bean;


public enum OperationEnum {
    REPLENISHMENT(0, "Пополнение счета"),
    WITHDRAWAL(1, "Снятие средств"),
    RENOUNCEMENT(2, "Отказ операции"),
    TRANSFER(3, "Перевод");

    private final int levelCode;
    private final String operationName;

    OperationEnum(int levelCode, String operationName) {
        this.levelCode = levelCode;
        this.operationName = operationName;
    }

    public int getLevelCode() {
        return this.levelCode;
    }

    public String getOperationName(){
        return this.operationName;
    }
}
