const express=require("express");
const router = express.Router();

const {
  createBookingController,
} = require("../controller/booking.controller");

router.post("/create", createBookingController);

module.exports = router;