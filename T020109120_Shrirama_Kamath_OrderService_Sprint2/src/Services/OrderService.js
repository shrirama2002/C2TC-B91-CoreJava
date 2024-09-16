import axios from "axios";

const BASE_API='http://localhost:8081/orders';

class OrderService
{
    getAllOrders(){
        return axios.get(BASE_API);
    }

    getOrderById(orderId){
        return axios.get(BASE_API+'/'+orderId);
    }

    createOrders(order){
        return axios.post(BASE_API,order);
    }

    updateOrders(orderID,order){
        return axios.put(BASE_API+'/'+orderID,order);
    }

    deleteOrders(orderID){
        return axios.delete(BASE_API+'/'+orderID);
    }
}

export default new OrderService();