import { Login } from './login';

describe('Login', () => {
  it('should create an instance', () => {
    expect(new Login('aaa', 'sss')).toBeTruthy();
  });
});
