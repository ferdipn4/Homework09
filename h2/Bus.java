package Homework09.h2;

import java.util.ArrayList;

public class Bus {

	public ArrayList<Passenger> passengers;

	public Bus() {
		passengers = new ArrayList<>();
	}

	public void enterBus(Passenger p) {
		passengers.add(p);
	}

	private void exitBus() {
		for (int i = passengers.size() - 1; i >= 0; i--) {
			Passenger p = passengers.get(i);
			if (p.planned == p.visited) {
				passengers.remove(i);
			}
		}
	}

	public void nextStop(Passenger[] boarding) {
		for (int i = 0; i < passengers.size(); i++) {
			Passenger p = passengers.get(i);
			p.visited += 1;
		}
		exitBus();
		if (boarding != null) {
			for (int i = 0; i < boarding.length; i++) {
				Passenger b = boarding[i];
				if (b != null) {
					passengers.add(b);
				}
			}
		}
	}

	public void nextStop() {
		nextStop(new Passenger[0]);
	}

	public ArrayList<Passenger> findPassengersWithoutTickets() {
		ArrayList<Passenger> removed = new ArrayList<>();
		for (int i = 0; i < passengers.size(); i++) {
			Passenger p = passengers.get(i);
			if (!p.ticket) {
				removed.add(p);
			}
		}
		for (int i = 0; i < removed.size(); i++) {
			passengers.remove(removed.get(i));
		}
		return removed;
	}

	public void transferPassengers(Bus otherBus, String[] passengerNames) {
		ArrayList<Passenger> toTransfer = new ArrayList<>();
		for (int i = 0; i < passengers.size(); i++) {
			Passenger p = passengers.get(i);
			for (int j = 0; j < passengerNames.length; j++) {
				if (p.name.equals(passengerNames[j])) {
					toTransfer.add(p);
					break;
				}
			}
		}
		for (int i = 0; i < toTransfer.size(); i++) {
			passengers.remove(toTransfer.get(i));
		}
		for (int i = 0; i < toTransfer.size(); i++) {
			otherBus.enterBus(toTransfer.get(i));
		}
	}

}
