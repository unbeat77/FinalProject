import { Orders } from './orders';

describe('Orders', () => {
  it('should create an instance', () => {
    let dateString1 = '2019-01-21 11:00:00' 
  let newDate1 = new Date(dateString1);
    expect(new Orders(1,	1, 1001, 1, "thank you",80,	"15:00:00",	"11:00:00",	newDate1,501, "DELIVERED")).toBeTruthy();
  });
});
