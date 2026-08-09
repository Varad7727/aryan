const mongoose = require("mongoose");


const dbconnection = async () => {
  try {
    await mongoose.connect(
      "mongodb+srv://Varad_7777:Varad123@cluster0.8apo1m3.mongodb.net/tikat"
    );

    console.log("Connection successful for DB!!");
  } catch (error) {
    console.log("DB connection failed:", error);
    process.exit(1);
  }
};

module.exports = dbconnection;