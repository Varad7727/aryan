const express=require("express")
const cors = require("cors");
const dbconnection=require("../server/database/db")
dbconnection()
const tripRoutes = require("./routes/trip.routes");
const sitRoutes=require("./routes/sit.routes");
const bookingRoutes=require("./routes/booking.routes")
const app=express();
app.use(cors());
app.use(express.json());

app.get("/", (req, res) => {
  res.send("hello im here");
});

app.use("/trip", tripRoutes);
app.use("/seat", sitRoutes);
app.use("/booking", bookingRoutes);

app.listen(8000,(req,res)=>{
    console.log("listening at port 8k");
})