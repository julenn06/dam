
export default {
  bootstrap: () => import('./main.server.mjs').then(m => m.default),
  inlineCriticalCss: false,
  baseHref: '/',
  locale: undefined,
  routes: [
  {
    "renderMode": 2,
    "route": "/"
  },
  {
    "renderMode": 2,
    "route": "/heroes"
  },
  {
    "renderMode": 0,
    "route": "/hero/*"
  }
],
  entryPointToBrowserMapping: undefined,
  assets: {
    'index.csr.html': {size: 448, hash: '3e7cad5aaf62da7bf7c54cf0adbdcf480061d935c5f376cc206953ade37970d0', text: () => import('./assets-chunks/index_csr_html.mjs').then(m => m.default)},
    'index.server.html': {size: 988, hash: '8be2aac2c8022ed28cc764632fa1c7765b34905f7a979165c48655e4fdd7bd21', text: () => import('./assets-chunks/index_server_html.mjs').then(m => m.default)},
    'index.html': {size: 3782, hash: '80735d55232e1e7db7d5d441a9378cca73480a760af27a8d2494013e1c182237', text: () => import('./assets-chunks/index_html.mjs').then(m => m.default)},
    'heroes/index.html': {size: 11601, hash: 'bb46e5853be9ef0a331419162ac4e080ce1425b984d66a377e4d3ae562f985d9', text: () => import('./assets-chunks/heroes_index_html.mjs').then(m => m.default)}
  },
};
