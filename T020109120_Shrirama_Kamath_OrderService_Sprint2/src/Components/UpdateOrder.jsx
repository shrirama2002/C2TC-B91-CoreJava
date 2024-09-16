import React,{useState,useEffect} from 'react'
import Proser from '../Services/OrderService';
import { useParams } from 'react-router-dom';

function UpdateOrder()
{
    const { id } = useParams();
    const [custid,setCustid]=useState("");
    const [storeid,setStoreid]=useState("");
    const [orderdate,setOrderdate]=useState("");
    const [totalprice,setTotalprice]=useState();
    const [status,setStatus]=useState("");
    const [pro, srtpro]=useState([]);
    const obj={
        id:id,
        customerId:custid,
        dateOfPurchase:orderdate,
        total:totalprice,
        paymentMode:status,
        shopId:storeid};

    const handelEve=(e)=>{
        e.preventDefault();
            Proser.updateOrders(id,obj)
            .then((res)=>{
                //console.log(obj)
                console.log(res);
            })
            .catch(err=>{
                console.log(err);
            })
        alert("Order updated successfully.,")

    }

    function getOrderById(id){
        Proser.getOrderById(id)
        .then((res)=>{
            srtpro(res.data)
        })
        .catch(err=>{
            console.log(err)
        })
    }

    useEffect(()=>{     
        getOrderById(id);
    })

    return(
        <div id="con">
            <h2>Update Order</h2>
            <form style={{display:'grid', gridTemplateColumns:'auto auto'}}>
                <div style={{width:'30rem', textAlign:'right'}}>
                    <h3 style={{marginBottom:'30px'}}>order Id: {pro.id}</h3>
                    <h3 style={{marginBottom:'30px'}}>Customer ID: {pro.custid}</h3>
                    <h3 style={{marginBottom:'30px'}}>Shop Id: {pro.storeid}</h3>
                    <h3 style={{marginBottom:'30px'}}>Order Date: {pro.orderdate}</h3>
                    <h3 style={{marginBottom:'30px'}}>Total Price: {pro.totalprice}</h3>
                    <h3 style={{marginBottom:'30px'}}>Mode of payment: {pro.status}</h3>
                </div>
                <div style={{textAlign:'left'}}>
                    <input disabled placeholder="Enter order Id" type='text' name='id' value={id}/><br/>
                    <input placeholder="Enter Customer Id" type='number' name='custid' onChange={(e)=>setCustid(e.target.value)} /><br/>
                    <input placeholder="Enter Store Id" type='number' name='stid'  onChange={(e)=>setStoreid(e.target.value)} /><br/>
                    <input placeholder="Enter Order date" type='date' name='orderdate' onChange={(e)=>setOrderdate(e.target.value)} /><br/>
                    <input placeholder="Enter Total Price" type='number' name='tprice' onChange={(e)=>setTotalprice(e.target.value)} /><br/>
                    <input placeholder="Enter Status" type='text' name='status' onChange={(e)=>setStatus(e.target.value)} /><br/>
                    <button onClick={handelEve} className='btn add' type='submit'>Submit</button>
                </div>
            </form>
        </div>
    )
}
export default UpdateOrder;