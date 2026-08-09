const express = require("express");
const {
  createTripController,
  getAllTipsController,
  getTripById,
  updateController,
  deleteTripController
} = require("../controller/trip.controller");

const router = express.Router();
router.post("/create", createTripController);
router.get("/all", getAllTipsController);
router.get("/:id", getTripById);
router.put("/:id", updateController);
router.delete("/:id", deleteTripController);

module.exports = router;
