package cn.tedu.pojo;

/**
 * Banji(班級)類對應的是數據庫中的Class表
 * 一般情況下 :基於表聲明的類 名字最好一致 除非表明在java中是具有特殊存在的內容時
 *
 */
public class Banji {
    /**
     * 基於表中有甚麼字段聲明甚麼屬性
     * 1.基於封裝原理 屬性一般都是屬於私有的(除非有特殊的情況存在)
     * 2.屬性的類型和表中字段的類型保持一致(建議使用包裝類型,基本類型容易造成岐異)
     * 3.屬性的名字和表中的字段名字一致
     * 4.有一種情況要注意 表中字段是由多個單詞用"_"作為連接的名字 在java中 應該遵循駝峰規則
     * ex. teacher_id --> teacherId
     * 5.屬性類必須要添加get and set方法 (toString方法也要加上)
     *
     */

    private Integer id ;// 對應表中的id字段 id int
    private String name;// name varchar
    private Integer floor;// floor int
    private Integer teacherId;// teacher_id int

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Banji{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", floor=" + floor +
                ", teacherId=" + teacherId +
                '}';
    }
}
