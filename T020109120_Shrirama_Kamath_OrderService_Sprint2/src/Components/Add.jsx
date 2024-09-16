import React,{useState} from 'react'
import Proser from '../Services/OrderService'

function Add()
{
    
    const [custid,setCustid]=useState("");
    const [storeid,setStoreid]=useState("");
    const [orderdate,setOrderdate]=useState("");
    const [totalprice,setTotalprice]=useState();
    const [paymentMod,setPaymentMode]=useState("");
    const obj={
        customerId:custid,
        dateOfPurchase:orderdate,
        total:totalprice,
        paymentMode:paymentMod,
        shopId:storeid};
    const handelEvent=(e)=>{
        e.preventDefault();
            Proser.createOrders(obj)
            .then((res)=>{
                console.log(res);
            })
            .catch(err=>{
                alert(err);
            })
        alert("Order added successfully.,!");   
    }

    return(
        <div id="con">
            <h2>Add order</h2>
            <form>
                <div>
                    <input placeholder="Enter Customer Id" type='number' name='custid' value={custid} onChange={(e)=>setCustid(e.target.value)} /><br/>
                    <input placeholder="Enter Store Id" type='number' name='stid' value={storeid}  onChange={(e)=>setStoreid(e.target.value)} /><br/>
                    <input placeholder="Enter Date of Purchase" type='date' name='orderdate' value={orderdate} onChange={(e)=>setOrderdate(e.target.value)} /><br/>
                    <input placeholder="Enter Total Amount" type='number' name='tprice' value={totalprice} onChange={(e)=>setTotalprice(e.target.value)} /><br/>
                    <input placeholder="Enter Payment Mode" type='text' name='paymentMod' value={paymentMod} onChange={(e)=>setPaymentMode(e.target.value)} /><br/>
                    <button onClick={handelEvent} className='btn add' type='submit'>Submit</button>
                </div>
            </form>
        </div>
    )
}
export default Add;