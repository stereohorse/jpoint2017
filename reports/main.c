#include <stdint.h>
#include <stdio.h>

int main() {
  int32_t val = 3454545;
  int32_t ep_ro = 3445;
  int32_t ret;

  ret = (int32_t)(((int64_t) val * ep_ro) >> 32);
  printf("%d\n", ret);

  return 0;
}
