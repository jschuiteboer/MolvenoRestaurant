package com.yacht.molvenorestaurant.business;

        import java.math.BigDecimal;
import java.util.List;

        public class Bill {
    private boolean isPaid;
    private Table table = new Table();
    private Guest guest = new Guest();
    private List<Dish> dishList;

            public void setPaid(boolean paid) {
                isPaid = paid;
            }

            public List<Dish> getDishList() {
                return dishList;
            }

            public void setDishList(List<Dish> dishList) {
                this.dishList = dishList;
            }

            public boolean isPaid() {
                return isPaid;
            }



            public Table getTable() {
                return table;
            }

            public void setTable(Table table) {
                this.table = table;
            }

            public Guest getGuest() {
                return guest;
            }

            public void setGuest(Guest guest) {
                this.guest = guest;
            }

            public BigDecimal getTotalPrice(){
                BigDecimal total = new BigDecimal(0);
                for(Dish dish: dishList) {
                        total = total.add(dish.getPrice());
                    }
                return total;
            }

            public void getTableNumber(){

                    }
}